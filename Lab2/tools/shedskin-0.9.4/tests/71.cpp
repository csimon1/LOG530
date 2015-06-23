#include "builtin.hpp"
#include "71.hpp"

namespace __71__ {


tuple2<__ss_int, __ss_int> *a;
list<tuple2<__ss_int, __ss_int> *> *b;
str *__name__;
list<list<double> *> *f;
list<__ss_int> *c;
list<double> *e;
list<list<__ss_int> *> *d;



void __init() {
    __name__ = new str("__main__");

    a = (new tuple2<__ss_int, __ss_int>(1,1));
    b = (new list<tuple2<__ss_int, __ss_int> *>(1,a));
    c = (new list<__ss_int>(1,1));
    e = (new list<double>(1,1.0));
    d = (new list<list<__ss_int> *>(1,c));
    f = (new list<list<double> *>(1,e));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__71__::__init);
}
