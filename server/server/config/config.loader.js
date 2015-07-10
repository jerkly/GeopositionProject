var path = require('path');
var extend = require('node.extend');
var program = require('./program');

var exist = function (name) {
    try {
        return require.resolve(name)
    }
    catch (e) {
        return false
    }
};

// moduleName is relative to path '/server/config/'
module.exports.load = function (moduleName) {
    var productionCfg = require(moduleName);
    Array.prototype.shift.apply(arguments);

    if (typeof(productionCfg) == 'function') {
        productionCfg = productionCfg.apply(null, arguments);
    }

    if (program.isTest()) {
        var cgfTestName = './' + path.basename(moduleName, '.js') + '.test';
        var testCfg = {};

        if (exist(cgfTestName)) {
            testCfg = require(cgfTestName);
            if (typeof(testCfg) == 'function') {
                testCfg = testCfg.apply(null, arguments);
            }
        }

        return extend(productionCfg, testCfg);
    }

    if (program.isDevelopment()) {
        var cgfLocalName = './' + path.basename(moduleName, '.js') + '.local';
        var developmentCfg = {};

        if (exist(cgfLocalName)) {
            developmentCfg = require(cgfLocalName);
            if (typeof(developmentCfg) == 'function') {
                developmentCfg = developmentCfg.apply(null, arguments);
            }
        }

        return extend(productionCfg, developmentCfg);
    }

    return productionCfg;
};