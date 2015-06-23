#include "builtin.hpp"
#include "13.hpp"

namespace __13__ {

str *const_0;


str *__name__;
__ss_int c;
fred *h;



/**
class fred
*/

class_ *cl_fred;

__ss_int fred::hottum(str *x) {
    __ss_int b;

    b = 4;
    return b;
}

void __init() {
    const_0 = new str("jo");

    __name__ = new str("__main__");

    cl_fred = new class_("fred");
    h = (new fred());
    c = h->hottum(const_0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__13__::__init);
}
