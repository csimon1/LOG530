#include "builtin.hpp"
#include "15.hpp"

namespace __15__ {

str *const_0;


str *__name__;



/**
class xevious
*/

class_ *cl_xevious;

__ss_int xevious::solvalou(__ss_int x) {
    
    return x;
}

__ss_int pacman(__ss_int a) {
    
    return 1;
}

__ss_int qbert() {
    xevious *x;
    __ss_int a, b, c, d, e;

    c = 1;
    a = 1;
    pacman(a);
    b = 1;
    a = c;
    d = 1;
    e = 1;
    x = (new xevious());
    x->y = d;
    x->z = const_0;
    x->solvalou(e);
    return b;
}

void __init() {
    const_0 = new str("hoi");

    __name__ = new str("__main__");

    cl_xevious = new class_("xevious");
    qbert();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__15__::__init);
}
