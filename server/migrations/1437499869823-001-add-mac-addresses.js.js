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

    macs.push(new MacPos({mac: 'BC671CE909F0', place: '307'}));
    macs.push(new MacPos({mac: '5067AE6A67EF', place: '307'}));
    macs.push(new MacPos({mac: '5067AE6A67ED', place: '307'}));

    macs.push(new MacPos({mac: '2834A2295210', place: '308'}));
    macs.push(new MacPos({mac: '2834A229521F', place: '308'}));
    macs.push(new MacPos({mac: '5067AE6A699F', place: '308'}));

    macs.push(new MacPos({mac: '00082F32E640', place: 'Negotiation  3'}));

    macs.push(new MacPos({mac: 'BC671CE9084D', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'BC671CE9094F', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: '00082F32d38F', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'BC671CE909FF', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: '00082F32d38D', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'BC671CE909FD', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'BC671CE909F0', place: 'Library floor 1'}));
    macs.push(new MacPos({mac: 'BC671CE909F2', place: 'Library floor 1'}));

    macs.push(new MacPos({mac: '00082F4A643D', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: '00082F4F643F', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: '00082F4A6430', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: '00082F4A6432', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: '6CFA89AD3EF0', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: 'BC671CE8F392', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: 'BC671CE8F39D', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: 'BC671CE8F39F', place: 'Library floor 2'}));
    macs.push(new MacPos({mac: '00082F4A5610', place: 'Library floor 2'}));

    macs.push(new MacPos({mac: '6CFA89AD3C3D', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3EFF', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3EFD', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '00082F32A990', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3C7F', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '00082f32A99D', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89C945B0', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '00082F32A99F', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3C70', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3EF0', place: 'Library floor 3'}));
    macs.push(new MacPos({mac: '6CFA89AD3EF2', place: 'Library floor 3'}));

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
