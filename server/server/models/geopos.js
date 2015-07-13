
var mongoose = require('mongoose');


// define the schema for our user model
var geoSchema = mongoose.Schema({


    clientID: Number,
    Time: { type: Date, default: Date.now },
    N: Number,
    E: Number,
    created: Date,
    updated: Date

});

// create the model for users and expose it to our app
module.exports = mongoose.model('geopos', geoSchema);