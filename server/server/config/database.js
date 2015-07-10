module.exports = {
    host: '127.0.0.1',
    port: '27017',
    name: 'geo',

    sessionStoreCollection: 'sessions',

    url: function() {
        return 'mongodb://' + this.host + ':' + this.port + '/' + this.name;
    }
};