#include "builtin.hpp"
#include "77.hpp"

namespace __77__ {

str *const_0, *const_1, *const_2;


list<str *> *u;
list<list<str *> *> *cnf;
str *__name__;
list<list<__ss_int> *> *cnf2;


static inline list<list<str *> *> *list_comp_0();
static inline list<list<__ss_int> *> *list_comp_1();

static inline list<list<str *> *> *list_comp_0() {
    list<str *> *__0;
    list<str *>::for_in_loop __3;
    str *x;
    __ss_int __2;
    __iter<str *> *__1;

    list<list<str *> *> *__ss_result = new list<list<str *> *>();

    FOR_IN(x,u,0,2,3)
        if (__NOT(x->startswith(const_0))) {
            __ss_result->append((x->strip())->split());
        }
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_1() {
    list<str *>::for_in_loop __7;
    list<str *> *__4;
    __iter<str *> *__5;
    __ss_int __6;
    str *x;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    __ss_result->resize(len(u));
    FOR_IN(x,u,4,6,7)
        __ss_result->units[__6] = (new list<__ss_int>(1,3));
    END_FOR

    return __ss_result;
}

void __init() {
    const_0 = __char_cache[120];;
    const_1 = new str(" p  o");
    const_2 = new str("c o ");

    __name__ = new str("__main__");

    u = (new list<str *>(2,const_1,const_2));
    cnf = list_comp_0();
    cnf2 = list_comp_1();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__77__::__init);
}
