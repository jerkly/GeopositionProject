var MacPos = require('../models/macpos');

module.exports.get_room = function (req, res, next) {

    var macAddress = req.params.mac;

    //new MacPos({mac: '00082f4a643f', place: 'Library 2'}).save();

    MacPos.findOne({mac: macAddress})
        .exec(function (err, pos) {
            if (err) {
                return next(err);
            }

            if (!pos) {
                return res.json({
                    name: '',
                    err: 'Not Found'
                });
            }

            res.json({name: pos.place, err: ''}).end();
        });
};