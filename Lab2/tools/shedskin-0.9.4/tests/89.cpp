#include "builtin.hpp"
#include "89.hpp"

namespace __89__ {


str *__name__;
dict<__ss_int, double> *e, *g;
dict<double, __ss_int> *f;



void __init() {
    __name__ = new str("__main__");

    f = (new dict<double, __ss_int>());
    f->__setitem__(1.0, 1);
    g = (new dict<__ss_int, double>());
    g->__setitem__(1, 1.0);
    e = (new dict<__ss_int, double>());
    e->__setitem__(4, 1.0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__89__::__init);
}
