using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using MongoDB.Bson;
using MongoDB.Driver;
using WebApp.Entities;
using WebApp.Pages;

namespace WebApp.Api;

[Route("api/[controller]")]
[ApiController]
public class OrdersController : ControllerBase
{
    private readonly ILogger<OrdersController> logger;
    private readonly IMongoCollection<Order> orderCollection;

    public OrdersController(ILogger<OrdersController> logger, IMongoClient mongoClient)
    {
        this.logger = logger;
        orderCollection = mongoClient.GetDatabase("test").GetCollection<Order>("orders");
    }

    [HttpGet]
    public async Task<IEnumerable<Order>> OnGet(string? search)
    {
        if (search is null)
        {
            return (await orderCollection.FindAsync<Order>(FilterDefinition<Order>.Empty)).ToEnumerable<Order>();
        }

        var regex = BsonRegularExpression.Create(search);
        var builder = Builders<Order>.Filter;
        return (await orderCollection.FindAsync<Order>(
            builder.Regex(o => o.Id, regex) |
            builder.Regex(o => o.FirstName, regex) |
            builder.Regex(o => o.LastName, regex) |
            builder.Regex(o => o.Email, regex) |
            builder.Regex(o => o.BirthDate, regex) |
            builder.Regex(o => o.Destination, regex) |
            builder.Regex(o => o.Discount,regex))).ToEnumerable<Order>();
    }

    [HttpDelete("{id}")]
    public Task OnDelete(string id)
    {
        return orderCollection.DeleteOneAsync(Builders<Order>.Filter.Eq(order => order.Id, id));
    }
}