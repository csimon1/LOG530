#include "builtin.hpp"
#include "21.hpp"

namespace __21__ {


tuple2<__ss_int, __ss_int> *a;
list<tuple2<__ss_int, __ss_int> *> *cube;
str *__name__;



tuple2<__ss_int, __ss_int> *gettuple() {
    
    return (new tuple2<__ss_int, __ss_int>(2,5,6));
}

void __init() {
    __name__ = new str("__main__");

    a = gettuple();
    cube = (new list<tuple2<__ss_int, __ss_int> *>(4,(new tuple2<__ss_int, __ss_int>(2,1,2)),(new tuple2<__ss_int, __ss_int>(2,3,4)),a,gettuple()));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__21__::__init);
}
