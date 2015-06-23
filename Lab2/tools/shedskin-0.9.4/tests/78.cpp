#include "builtin.hpp"
#include "78.hpp"

namespace __78__ {

str *const_0;


list<str *> *__0, *cnf;
list<str *>::for_in_loop __3;
__iter<str *> *__1;
__ss_int __2, d;
str *__name__, *x;



void __init() {
    const_0 = __char_cache[56];;

    __name__ = new str("__main__");

    cnf = (new list<str *>(1,const_0));

    FOR_IN(x,cnf,0,2,3)
        d = __int(x);
    END_FOR

}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__78__::__init);
}
