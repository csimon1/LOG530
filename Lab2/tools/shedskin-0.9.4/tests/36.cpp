#include "builtin.hpp"
#include "36.hpp"

namespace __36__ {

str *const_0, *const_1;


list<str *> *argv;
list<__ss_int> *cnf;
str *__name__, *x;


static inline list<__ss_int> *list_comp_0();

static inline list<__ss_int> *list_comp_0() {
    __iter<__ss_int> *__1;
    list<__ss_int> *__0;
    __ss_int __2, y;
    list<__ss_int>::for_in_loop __3;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __0 = ffile(x);
    __ss_result->resize(len(__0));
    FOR_IN(y,__0,0,2,3)
        __ss_result->units[__2] = y;
    END_FOR

    return __ss_result;
}

list<__ss_int> *ffile(str *name) {
    
    return (new list<__ss_int>(1,1));
}

void __init() {
    const_0 = new str("");
    const_1 = new str("testdata/uuf250-010.cnf");

    __name__ = new str("__main__");

    argv = (new list<str *>(2,const_0,const_1));
    x = argv->__getfast__(0);
    cnf = list_comp_0();
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__36__::__init);
}
