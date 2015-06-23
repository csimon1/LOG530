#include "builtin.hpp"
#include "9.hpp"

namespace __9__ {


str *__name__;
fred *a, *b;



/**
class fred
*/

class_ *cl_fred;

fred *fred::__add__(fred *x) {
    
    return x;
}

void __init() {
    __name__ = new str("__main__");

    cl_fred = new class_("fred");
    a = (new fred());
    b = (a)->__add__(a);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__9__::__init);
}
