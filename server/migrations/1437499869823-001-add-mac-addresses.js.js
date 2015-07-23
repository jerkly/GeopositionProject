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

    macs.push(new MacPos({mac: 'bc671ce909f0', place: '307'}));
    macs.push(new MacPos({mac: '5067ae6a67ef', place: '307'}));

    macs.push(new MacPos({mac: '2834a2295210', place: '308'}));
    macs.push(new MacPos({mac: '2834a2295210', place: '308'}));

    macs.push(new MacPos({mac: 'bc671ce9084d', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'bc671ce909fd', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: '00082f32d38f', place: 'Library floor 1'}));

    macs.push(new MacPos({mac: '00082f4a643d', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: 'bc671ce8f392', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: '00082f4a5610', place: 'Library floor 2'}));

    macs.push(new MacPos({mac: '6CFA89AD3C3D', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3C7F', place: 'Library floor 3'}));
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
