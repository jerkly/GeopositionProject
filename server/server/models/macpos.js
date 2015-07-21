var mongoose = require('mongoose');

var macPosSchema = mongoose.Schema({
    mac: String,
    place: String
});

// create the model for users and expose it to our app
module.exports = mongoose.model('MacPos', macPosSchema);