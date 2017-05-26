(function (e, t, n) {
    function c() {
        s = t[o](function () {
            r.each(function () {
                var t = e(this), n = t.width(), r = t.height(), i = e.data(this, a);
                if (n !== i.w || r !== i.h) {
                    t.trigger(u, [i.w = n, i.h = r])
                }
            });
            c()
        }, i[f])
    }

    var r = e([]), i = e.resize = e.extend(e.resize, {}), s, o = "setTimeout", u = "resize", a = u + "-special-event", f = "delay", l = "throttleWindow";
    i[f] = 250;
    i[l] = true;
    e.event.special[u] = {
        setup: function () {
            if (!i[l] && this[o]) {
                return false
            }
            var t = e(this);
            r = r.add(t);
            e.data(this, a, {w: t.width(), h: t.height()});
            if (r.length === 1) {
                c()
            }
        }, teardown: function () {
            if (!i[l] && this[o]) {
                return false
            }
            var t = e(this);
            r = r.not(t);
            t.removeData(a);
            if (!r.length) {
                clearTimeout(s)
            }
        }, add: function (t) {
            function s(t, i, s) {
                var o = e(this), u = e.data(this, a);
                u.w = i !== n ? i : o.width();
                u.h = s !== n ? s : o.height();
                r.apply(this, arguments)
            }

            if (!i[l] && this[o]) {
                return false
            }
            var r;
            if (e.isFunction(t)) {
                r = t;
                return s
            } else {
                r = t.handler;
                t.handler = s
            }
        }
    }
})(jQuery, this);
(function (e) {
    function n(e) {
        function t() {
            var t = e.getPlaceholder();
            if (t.width() == 0 || t.height() == 0)return;
            e.resize();
            e.setupGrid();
            e.draw()
        }

        function n(e, n) {
            e.getPlaceholder().resize(t)
        }

        function r(e, n) {
            e.getPlaceholder().unbind("resize", t)
        }

        e.hooks.bindEvents.push(n);
        e.hooks.shutdown.push(r)
    }

    var t = {};
    e.plot.plugins.push({init: n, options: t, name: "resize", version: "1.0"})
})(jQuery)