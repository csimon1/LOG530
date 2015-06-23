#include "builtin.hpp"
#include "43.hpp"

namespace __43__ {


str *__name__;


static inline list<__ss_int> *list_comp_0(list<__ss_int> *bla);
static inline list<__ss_int> *list_comp_1(list<__ss_int> *bla);
static inline list<list<__ss_int> *> *list_comp_2(list<__ss_int> *bla, list<__ss_int> *dinges);
static inline list<__ss_int> *list_comp_3(list<__ss_int> *jada);
static inline list<list<__ss_int> *> *list_comp_4(list<__ss_int> *bla, list<__ss_int> *jada);
static inline list<list<list<__ss_int> *> *> *list_comp_5(list<__ss_int> *bla, list<__ss_int> *jada, list<__ss_int> *dinges);

static inline list<__ss_int> *list_comp_0(list<__ss_int> *bla) {
    __iter<__ss_int> *__1;
    list<__ss_int> *__0;
    __ss_int __2, x;
    list<__ss_int>::for_in_loop __3;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(bla));
    FOR_IN(x,bla,0,2,3)
        __ss_result->units[__2] = x;
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_1(list<__ss_int> *bla) {
    __iter<__ss_int> *__9;
    list<__ss_int> *__8;
    __ss_int __10, a;
    list<__ss_int>::for_in_loop __11;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(bla));
    FOR_IN(a,bla,8,10,11)
        __ss_result->units[__10] = a;
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_2(list<__ss_int> *bla, list<__ss_int> *dinges) {
    __iter<__ss_int> *__5;
    list<__ss_int> *__4;
    __ss_int __6, c;
    list<__ss_int>::for_in_loop __7;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    __ss_result->resize(len(dinges));
    FOR_IN(c,dinges,4,6,7)
        __ss_result->units[__6] = list_comp_1(bla);
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_3(list<__ss_int> *jada) {
    __iter<__ss_int> *__21;
    list<__ss_int> *__20;
    __ss_int __22, a;
    list<__ss_int>::for_in_loop __23;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(jada));
    FOR_IN(a,jada,20,22,23)
        __ss_result->units[__22] = a;
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_4(list<__ss_int> *bla, list<__ss_int> *jada) {
    __iter<__ss_int> *__17;
    list<__ss_int> *__16;
    __ss_int __18, c;
    list<__ss_int>::for_in_loop __19;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    __ss_result->resize(len(bla));
    FOR_IN(c,bla,16,18,19)
        __ss_result->units[__18] = list_comp_3(jada);
    END_FOR

    return __ss_result;
}

static inline list<list<list<__ss_int> *> *> *list_comp_5(list<__ss_int> *bla, list<__ss_int> *jada, list<__ss_int> *dinges) {
    __iter<__ss_int> *__13;
    list<__ss_int> *__12;
    __ss_int __14, d;
    list<__ss_int>::for_in_loop __15;

    list<list<list<__ss_int> *> *> *__ss_result = new list<list<list<__ss_int> *> *>();

    __ss_result->resize(len(dinges));
    FOR_IN(d,dinges,12,14,15)
        __ss_result->units[__14] = list_comp_4(bla, jada);
    END_FOR

    return __ss_result;
}

list<__ss_int> *hoi() {
    list<__ss_int> *bla, *dinges, *jada, *u;
    list<list<list<__ss_int> *> *> *w;
    list<list<__ss_int> *> *v;

    bla = (new list<__ss_int>(2,1,2));
    dinges = (new list<__ss_int>(2,1,2));
    jada = (new list<__ss_int>(2,1,2));
    u = list_comp_0(bla);
    v = list_comp_2(bla, dinges);
    w = list_comp_5(bla, jada, dinges);
    print2(NULL,0,1, u);
    print2(NULL,0,1, v);
    print2(NULL,0,1, w);
    return bla;
    return dinges;
}

void __init() {
    __name__ = new str("__main__");

    print2(NULL,0,1, hoi());
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__43__::__init);
}
