#include "builtin.hpp"
#include "56.hpp"

namespace __56__ {

str *const_0, *const_1;


str *__name__;



double hoi(double a, double b, __ss_int e) {
    double c, d;
    __ss_int f, g, h;
    str *s;

    c = a;
    d = b;
    f = 1;
    g = 1;
    h = (f+g);
    s = (const_0)->__add__(const_1);
    return (c+d);
}

void __init() {
    const_0 = new str("ho");
    const_1 = __char_cache[105];;

    __name__ = new str("__main__");

    hoi(((double)(1)), ((double)(2)), 3);
    hoi(1.0, 2.0, 4);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__56__::__init);
}
