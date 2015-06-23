#include "builtin.hpp"
#include "25.hpp"

namespace __25__ {


list<pyseq<__ss_int> *> *cube;
str *__name__;



void __init() {
    __name__ = new str("__main__");

    cube = (new list<pyseq<__ss_int> *>(2,(new list<__ss_int>(2,1,2)),(new tuple2<__ss_int, __ss_int>(2,3,4))));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__25__::__init);
}
