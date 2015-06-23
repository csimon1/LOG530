#include "builtin.hpp"
#include "83.hpp"

namespace __83__ {


list<__ss_int> *lit_mask;
str *__name__;



void *propagate(__ss_int lit) {
    list<__ss_int> *__0;
    __ss_int __1;

    __0 = lit_mask;
    __1 = lit;
    __0->__setitem__(__1, ((__0->__getfast__(__1))|(1)));
    return NULL;
}

void *lookahead() {
    
    lit_mask = (new list<__ss_int>(1,1));
    return NULL;
}

void __init() {
    __name__ = new str("__main__");

    lookahead();
    propagate(0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__83__::__init);
}
