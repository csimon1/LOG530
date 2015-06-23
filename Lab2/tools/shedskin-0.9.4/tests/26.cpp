#include "builtin.hpp"
#include "26.hpp"

namespace __26__ {


list<tuple2<__ss_int, __ss_int> *> *cube;
str *__name__;



void __init() {
    __name__ = new str("__main__");

    cube = (new list<tuple2<__ss_int, __ss_int> *>(2,(new tuple2<__ss_int, __ss_int>(2,1,2)),(new tuple2<__ss_int, __ss_int>(2,3,4))));
    cube->__setitem__(0, (new tuple2<__ss_int, __ss_int>(2,1,2)));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__26__::__init);
}
