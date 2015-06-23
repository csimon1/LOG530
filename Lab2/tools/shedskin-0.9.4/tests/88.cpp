#include "builtin.hpp"
#include "88.hpp"

namespace __88__ {

str *const_0;


list<str *> *d;
str *__name__;
list<__ss_int> *c;
list<list<str *> *> *b;
list<list<__ss_int> *> *a;



void __init() {
    const_0 = new str("");

    __name__ = new str("__main__");

    a = (new list<list<__ss_int> *>(60,(new list<__ss_int>(1,0)),(new list<__ss_int>(1,1)),(new list<__ss_int>(1,2)),(new list<__ss_int>(1,3)),(new list<__ss_int>(1,4)),(new list<__ss_int>(1,5)),(new list<__ss_int>(1,6)),(new list<__ss_int>(1,7)),(new list<__ss_int>(1,8)),(new list<__ss_int>(1,9)),(new list<__ss_int>(1,0)),(new list<__ss_int>(1,1)),(new list<__ss_int>(1,2)),(new list<__ss_int>(1,3)),(new list<__ss_int>(1,4)),(new list<__ss_int>(1,5)),(new list<__ss_int>(1,6)),(new list<__ss_int>(1,7)),(new list<__ss_int>(1,8)),(new list<__ss_int>(1,9)),(new list<__ss_int>(1,0)),(new list<__ss_int>(1,1)),(new list<__ss_int>(1,2)),(new list<__ss_int>(1,3)),(new list<__ss_int>(1,4)),(new list<__ss_int>(1,5)),(new list<__ss_int>(1,6)),(new list<__ss_int>(1,7)),(new list<__ss_int>(1,8)),(new list<__ss_int>(1,9)),(new list<__ss_int>(1,0)),(new list<__ss_int>(1,1)),(new list<__ss_int>(1,2)),(new list<__ss_int>(1,3)),(new list<__ss_int>(1,4)),(new list<__ss_int>(1,5)),(new list<__ss_int>(1,6)),(new list<__ss_int>(1,7)),(new list<__ss_int>(1,8)),(new list<__ss_int>(1,9)),(new list<__ss_int>(1,0)),(new list<__ss_int>(1,1)),(new list<__ss_int>(1,2)),(new list<__ss_int>(1,3)),(new list<__ss_int>(1,4)),(new list<__ss_int>(1,5)),(new list<__ss_int>(1,6)),(new list<__ss_int>(1,7)),(new list<__ss_int>(1,8)),(new list<__ss_int>(1,9)),(new list<__ss_int>(1,0)),(new list<__ss_int>(1,1)),(new list<__ss_int>(1,2)),(new list<__ss_int>(1,3)),(new list<__ss_int>(1,4)),(new list<__ss_int>(1,5)),(new list<__ss_int>(1,6)),(new list<__ss_int>(1,7)),(new list<__ss_int>(1,8)),(new list<__ss_int>(1,9))));
    c = a->__getfast__(0);
    c->append(1);
    b = (new list<list<str *> *>(1,(new list<str *>(1,const_0))));
    d = b->__getfast__(0);
    d->append(const_0);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__88__::__init);
}
