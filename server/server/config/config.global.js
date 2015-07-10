var loader = require('./config.loader');

module.exports = {
    process: loader.load('./process'),
    db: loader.load('./database'),
    program: loader.load('./program'),
    session: loader.load('./session')
};