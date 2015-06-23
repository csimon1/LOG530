#include "builtin.hpp"
#include "38.hpp"

namespace __38__ {


list<__ss_int> *a;
str *__name__;


static inline list<__ss_int> *list_comp_0();

static inline list<__ss_int> *list_comp_0() {
    __iter<__ss_int> *__1;
    list<__ss_int> *__0;
    __ss_int __2, i;
    list<__ss_int>::for_in_loop __3;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __0 = hu(10, (-1));
    __ss_result->resize(len(__0));
    FOR_IN(i,__0,0,2,3)
        __ss_result->units[__2] = i;
    END_FOR

    return __ss_result;
}

list<__ss_int> *hu(__ss_int n, __ss_int s) {
    
    return (new list<__ss_int>(1,1));
}

void __init() {
    __name__ = new str("__main__");

    a = list_comp_0();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__38__::__init);
}
