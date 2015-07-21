var express = require('express');
var path = require('path');
var mainHandler = require('./apiHandlers/main.handler');

module.exports = function (app) {

    app.get('/api/room/:mac', mainHandler.get_room);

    app.get('/*', function (req, res) {
        res.render('index.html');
    });
};

