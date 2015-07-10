var mongoose = require('mongoose');
var config = require('../config/config.global');

module.exports = mongoose.connect(config.db.url());