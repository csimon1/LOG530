#include "builtin.hpp"
#include "50.hpp"

namespace __50__ {

str *const_0;


list<str *> *b;
list<__ss_int> *a;
str *__name__;
list<list<__ss_int> *> *c;



void __init() {
    const_0 = __char_cache[49];;

    __name__ = new str("__main__");

    a = (new list<__ss_int>());
    a->append(1);
    b = (new list<str *>());
    b->append(const_0);
    c = (new list<list<__ss_int> *>());
    c->append((new list<__ss_int>(1,1)));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__50__::__init);
}
