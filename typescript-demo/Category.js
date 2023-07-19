"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Category = void 0;
var Category = /** @class */ (function () {
    function Category(_name, _desc) {
        this._name = _name;
        this._desc = _desc;
    }
    Object.defineProperty(Category.prototype, "name", {
        get: function () {
            return this._name;
        },
        set: function (value) {
            this._name = value;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Category.prototype, "desc", {
        get: function () {
            return this._desc;
        },
        set: function (value) {
            this._desc = value;
        },
        enumerable: false,
        configurable: true
    });
    return Category;
}());
exports.Category = Category;
