#include "builtin.hpp"
#include "11.hpp"

namespace __11__ {


str *__name__;
__ss_int b;
fred *a;



/**
class fred
*/

class_ *cl_fred;

void *fred::huh() {
    
    this->_a = 1;
    return NULL;
}

void __init() {
    __name__ = new str("__main__");

    cl_fred = new class_("fred");
    a = (new fred());
    a->huh();
    b = a->_a;
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__11__::__init);
}
