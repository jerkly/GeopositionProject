var MacPos = require('../models/macpos');

module.exports.get_room = function (req, res, next) {

    var macAddress = req.params.mac;

    MacPos.findOne({mac: macAddress})
        .exec(function (err, pos) {
            if (err) {
                return next(err);
            }

            if (!pos) {
                return res.json({err: 'Not Found'});
            }

            res.json({name: pos.place}).end();
        });
};