require('../server/init/database.init');
var MacPos = require('../server/models/macpos');

exports.up = function(next) {
    var macs = [];

    macs.push(new MacPos({mac: 'B000B49B69C0', place: '105'}));
    macs.push(new MacPos({mac: '544A0066E64F', place: '105'}));
    macs.push(new MacPos({mac: '544A0066E5EF', place: '105'}));

    macs.push(new MacPos({mac: '5067AE6A67E0', place: '107'}));
    macs.push(new MacPos({mac: '5067AE6A6660', place: '107'}));

    macs.push(new MacPos({mac: '5067AE6A699F', place: '108'}));
    macs.push(new MacPos({mac: '5067AE6A699F', place: '108'}));

    macs.push(new MacPos({mac: '00082F32BDE0', place: '307'}));
    macs.push(new MacPos({mac: '00082F4A9010', place: '307'}));

    macs.push(new MacPos({mac: '00082F32D380', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'BC671CE909F0', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'BC671CE9084F', place: 'Library floor 1'}));

    macs.push(new MacPos({mac: 'BC671CE8F390', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: '00082F4A5610', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: 'BC671CE8F39D', place: 'Library floor 2'}));

    macs.push(new MacPos({mac: '6CFA89AD3EFF', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '00082F32A990', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3C7F', place: 'Library floor 3'}));

    MacPos.create(macs, function(err, docs) {
        if (err) {
            console.error(err);
            // TODO: handle error
        } else {
            console.info('%d potatoes were successfully stored.', docs.length);
        }
        next();
    });
};

exports.down = function(next) {
    next();
};
