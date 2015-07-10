var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var morgan = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');

var csrf = require('csurf');
var config = require('./config/config.global.js');

require('./init/database.init');

var app = express();

// view engine setup
app.set('views', path.resolve(__dirname, '../public/views'));
app.engine('html', require('ejs').renderFile);
app.set('view engine', 'html');


app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));
app.use(cookieParser());
app.use(require('less-middleware')(path.join(__dirname, 'public')));
app.use(express.static(path.join(__dirname, '../public')));
app.use(express.static(path.join(__dirname, '../data')));


// routes ======================================================================
require('./routes.js')(app); // load our routes and pass in our app and fully configured passport


// catch 404 and forward to error handler
app.use(function (req, res, next) {
    var err = new Error('Not Found');
    err.status = 404;
    next(err);
});

app.use(function (err, req, res, next) {
    if (!(config.program.isTest() && err.status)) {
        logger.error(err.stack);
    }
    res.status(err.status || 500);
    res.json({
        message: err.message
    });
});


module.exports = app;
