#!/usr/bin/env node

var program = require('commander');
var winston = require('winston');

program
    .version('0.0.1')
    .option('-m, --mode [type]', 'Add the specified type of running mode [production, development, test]', 'production')
    .parse(process.argv);

winston.info('Server started in %s mode', program.mode);

module.exports.program = program;

module.exports.isProduction = function() {
    return program.mode == 'production';
};

module.exports.isDevelopment = function() {
    return program.mode == 'development';
};

module.exports.isTest = function() {
    return program.mode == 'test';
};