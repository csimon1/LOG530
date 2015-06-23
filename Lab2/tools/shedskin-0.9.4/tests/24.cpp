#include "builtin.hpp"
#include "24.hpp"

namespace __24__ {


str *__name__;
integer *a;



/**
class integer
*/

class_ *cl_integer;

void integer::__static__() {
}

/**
class fred
*/

class_ *cl_fred;

integer *fred::__add__(fred *x) {
    integer *i;

    i = (new integer());
    return i;
}

integer *hoei() {
    fred *a;

    a = (new fred());
    return (a)->__add__(a);
}

void __init() {
    __name__ = new str("__main__");

    cl_integer = new class_("integer");
    integer::__static__();
    cl_fred = new class_("fred");
    a = hoei();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__24__::__init);
}
