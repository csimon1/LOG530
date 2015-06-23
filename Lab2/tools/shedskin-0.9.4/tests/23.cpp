#include "builtin.hpp"
#include "23.hpp"

namespace __23__ {


list<tuple2<__ss_int, __ss_int> *> *cube;
tuple2<__ss_int, __ss_int> *b;
str *__name__;



tuple2<__ss_int, __ss_int> *hoei(list<tuple2<__ss_int, __ss_int> *> *cube) {
    tuple2<__ss_int, __ss_int> *pos, *x;
    list<tuple2<__ss_int, __ss_int> *> *__0;
    __iter<tuple2<__ss_int, __ss_int> *> *__1;
    list<tuple2<__ss_int, __ss_int> *>::for_in_loop __3;
    __ss_int __2;


    FOR_IN(pos,cube,0,2,3)
        x = pos;
    END_FOR

    return x;
}

void __init() {
    __name__ = new str("__main__");

    cube = (new list<tuple2<__ss_int, __ss_int> *>(3,(new tuple2<__ss_int, __ss_int>(2,1,2)),(new tuple2<__ss_int, __ss_int>(2,3,4)),(new tuple2<__ss_int, __ss_int>(2,5,6))));
    b = hoei(cube);
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__23__::__init);
}
