#include "builtin.hpp"
#include "81.hpp"

namespace __81__ {

str *const_0;


lambda0 acc;
list<__ss_int> *score;
str *__name__;


static inline __ss_int __lambda0__(__ss_int x, __ss_int y);

static inline __ss_int __lambda0__(__ss_int x, __ss_int y) {
    
    return (x+y);
}

__ss_int _reduce(lambda0 f, list<__ss_int> *l, __ss_int i) {
    __ss_int __0, __1, r;

    if (__NOT(___bool(l))) {
        if ((i!=(-1))) {
            return i;
        }
        print2(NULL,0,1, const_0);
    }
    if ((i!=(-1))) {
        r = f(i, l->__getfast__(0));
    }
    else {
        r = l->__getfast__(0);
    }

    FAST_FOR(i,0,(len(l)-1),1,0,1)
        r = f(r, l->__getfast__((i+1)));
    END_FOR

    return r;
}

void __init() {
    const_0 = new str("*** ERROR! *** reduce() called with empty sequence and no initial value");

    __name__ = new str("__main__");

    acc = __lambda0__;
    score = (new list<__ss_int>(4,1,2,3,4));
    print2(NULL,0,1, ___box(_reduce(acc, score, 0)));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__81__::__init);
}
