var morgan = require('morgan');
var config = require('../config/config.global');

var init = function (app) {
    if (config.program.isProduction() || config.program.isDevelopment()) {
        morgan.token('remote-user', function (req) {
            return (req.isAuthenticated() && ['[', req.user.local.email, ']'].join('')) || '-';
        });
        app.use(morgan('common'));
    }
};

module.exports = init;