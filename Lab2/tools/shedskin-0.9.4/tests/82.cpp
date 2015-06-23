#include "builtin.hpp"
#include "82.hpp"

namespace __82__ {


list<__ss_int> *a, *vars;
str *__name__;


static inline list<__ss_int> *list_comp_0();

static inline list<__ss_int> *list_comp_0() {
    __iter<__ss_int> *__1;
    list<__ss_int> *__0;
    __ss_int __2, var;
    list<__ss_int>::for_in_loop __3;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(vars));
    FOR_IN(var,vars,0,2,3)
        __ss_result->units[__2] = var;
    END_FOR

    return __ss_result;
}

list<__ss_int> *bla() {
    
    return list_comp_0();
}

void __init() {
    __name__ = new str("__main__");

    vars = (new list<__ss_int>(1,1));
    a = bla();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__82__::__init);
}
