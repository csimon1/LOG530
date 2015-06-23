#include "builtin.hpp"
#include "22.hpp"

namespace __22__ {


tuple2<__ss_int, __ss_int> *a;
list<tuple2<__ss_int, __ss_int> *> *__0;
list<tuple2<__ss_int, __ss_int> *>::for_in_loop __3;
str *__name__;
__iter<tuple2<__ss_int, __ss_int> *> *__1;
__ss_int __2;



void __init() {
    __name__ = new str("__main__");


    FOR_IN(a,(new list<tuple2<__ss_int, __ss_int> *>(2,(new tuple2<__ss_int, __ss_int>(2,1,2)),(new tuple2<__ss_int, __ss_int>(2,3,4)))),0,2,3)
    END_FOR

}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__22__::__init);
}
