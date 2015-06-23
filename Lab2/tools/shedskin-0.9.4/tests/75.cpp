#include "builtin.hpp"
#include "75.hpp"

namespace __75__ {


list<tuple2<__ss_int, __ss_int> *> *d;
list<__ss_int> *a;
list<double> *b;
str *__name__;
list<list<__ss_int> *> *e;



void __init() {
    __name__ = new str("__main__");

    a = (new list<__ss_int>(4,1,2,3,4));
    b = (new list<double>(1,1.0));
    d = (new list<tuple2<__ss_int, __ss_int> *>(1,(new tuple2<__ss_int, __ss_int>(1,1))));
    e = (new list<list<__ss_int> *>(2,(new list<__ss_int>(2,1,2)),(new list<__ss_int>(3,2,3,4))));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__75__::__init);
}
