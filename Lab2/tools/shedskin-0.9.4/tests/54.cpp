#include "builtin.hpp"
#include "copy.hpp"
#include "54.hpp"

namespace __54__ {


list<__ss_int> *a, *b;
str *__name__;



/**
class bert
*/

class_ *cl_bert;

void bert::__static__() {
}

void __init() {
    __name__ = new str("__main__");

    cl_bert = new class_("bert");
    bert::__static__();
    a = (new list<__ss_int>(2,1,2));
    b = __copy__::deepcopy(a);
    a->__setitem__(0, 3);
    print2(NULL,0,2, a, b);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __copy__::__init();
    __shedskin__::__start(__54__::__init);
}
