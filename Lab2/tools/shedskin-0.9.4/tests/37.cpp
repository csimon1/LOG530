#include "builtin.hpp"
#include "37.hpp"

namespace __37__ {

str *const_0, *const_1, *const_10, *const_2, *const_3, *const_4, *const_5, *const_6, *const_7, *const_8, *const_9;


__iter<__ss_int> *__27;
list<str *> *argv;
__iter<list<__ss_int> *> *__23;
list<__ss_int>::for_in_loop __29;
list<list<__ss_int> *>::for_in_loop __25;
list<__ss_int> *__26, *clause, *fixedt, *lit_mask, *vars;
list<list<__ss_int> *> *__22, *clauses;
str *__name__;
list<list<str *> *> *cnf;
__ss_int __24, __28, bincount, global_mask, hoppa, lit, nodecount, nrofvars, part_mask, propcount, some_failure;
list<list<list<__ss_int> *> *> *occurrence;


static inline list<list<str *> *> *list_comp_0();
static inline list<__ss_int> *list_comp_1(list<str *> *l);
static inline list<list<__ss_int> *> *list_comp_2();
static inline list<__ss_int> *list_comp_3();
static inline list<list<list<__ss_int> *> *> *list_comp_4();
static inline list<__ss_int> *list_comp_5();
static inline list<str *> *list_comp_6();
static inline list<__ss_int> *list_comp_7();
static inline list<list<__ss_int> *> *list_comp_8(list<__ss_int> *u);
static inline list<__ss_int> *list_comp_9();
static inline list<__ss_int> *list_comp_10();
static inline list<__ss_int> *list_comp_11();
static inline list<__ss_int> *list_comp_12();
static inline list<__ss_int> *list_comp_13();
static inline __ss_int __lambda0__(__ss_int x, __ss_int y);

static inline list<list<str *> *> *list_comp_0() {
    file *__2;
    str *l;
    __ss_int __4;
    __iter<str *> *__3;
    file::for_in_loop __5;

    list<list<str *> *> *__ss_result = new list<list<str *> *>();

    __2 = (new file(argv->__getfast__(1)));
    FOR_IN(l,__2,2,4,5)
        if ((!(const_0)->__contains__(l->__getfast__(0)))) {
            __ss_result->append((l->strip())->split());
        }
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_1(list<str *> *l) {
    list<str *>::for_in_loop __13;
    list<str *> *__10;
    __iter<str *> *__11;
    __ss_int __12;
    str *x;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __10 = l->__slice__(2, 0, (-1), 0);
    FOR_IN(x,__10,10,12,13)
        if (__ne(x, const_1)) {
            __ss_result->append(__int(x));
        }
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_2() {
    __iter<list<str *> *> *__7;
    list<str *> *l;
    list<list<str *> *> *__6;
    __ss_int __8;
    list<list<str *> *>::for_in_loop __9;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    FOR_IN(l,cnf,6,8,9)
        if (__ne(l->__getfast__(0), const_2)) {
            __ss_result->append(list_comp_1(l));
        }
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_3() {
    __iter<list<str *> *> *__15;
    list<str *> *l;
    list<list<str *> *> *__14;
    __ss_int __16;
    list<list<str *> *>::for_in_loop __17;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FOR_IN(l,cnf,14,16,17)
        if (__eq(l->__getfast__(0), const_2)) {
            __ss_result->append(__int(l->__getfast__(2)));
        }
    END_FOR

    return __ss_result;
}

static inline list<list<list<__ss_int> *> *> *list_comp_4() {
    __iter<__ss_int> *__19;
    list<__ss_int> *__18;
    __ss_int __20, l;
    list<__ss_int>::for_in_loop __21;

    list<list<list<__ss_int> *> *> *__ss_result = new list<list<list<__ss_int> *> *>();

    __18 = __mul2(2, vars);
    __ss_result->resize(len(__18));
    FOR_IN(l,__18,18,20,21)
        __ss_result->units[__20] = (new list<list<__ss_int> *>());
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_5() {
    __iter<__ss_int> *__31;
    list<__ss_int> *__30;
    __ss_int __32, var;
    list<__ss_int>::for_in_loop __33;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(vars));
    FOR_IN(var,vars,30,32,33)
        __ss_result->units[__32] = (-1);
    END_FOR

    return __ss_result;
}

static inline list<str *> *list_comp_6() {
    __ss_int __34, __35, i;

    list<str *> *__ss_result = new list<str *>();

    FAST_FOR(i,1,(nrofvars+1),1,34,35)
        __ss_result->append(__str((((2*fixedt->__getfast__(i))-1)*i)));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_7() {
    __ss_int __53, __54, var;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FAST_FOR(var,0,(2*(nrofvars+1)),1,53,54)
        __ss_result->append(0);
    END_FOR

    return __ss_result;
}

static inline list<list<__ss_int> *> *list_comp_8(list<__ss_int> *u) {
    __ss_int __55, __56, i;

    list<list<__ss_int> *> *__ss_result = new list<list<__ss_int> *>();

    FAST_FOR(i,0,32,1,55,56)
        __ss_result->append(u->__slice__(3, ((i*len(u))>>5), (((i+1)*len(u))>>5), 0));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_9() {
    __ss_int __57, __58, i;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FAST_FOR(i,0,32,1,57,58)
        __ss_result->append((1<<i));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_10() {
    __ss_int __59, __60, var;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FAST_FOR(var,0,(nrofvars+1),1,59,60)
        __ss_result->append((-1));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_11() {
    __iter<__ss_int> *__62;
    list<__ss_int> *__61;
    __ss_int __63, m;
    list<__ss_int>::for_in_loop __64;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    __ss_result->resize(len(lit_mask));
    FOR_IN(m,lit_mask,61,63,64)
        __ss_result->units[__63] = ((m)&((hoppa-global_mask)));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_12() {
    __ss_int __75, __76, var;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FAST_FOR(var,0,(nrofvars+1),1,75,76)
        __ss_result->append((-1));
    END_FOR

    return __ss_result;
}

static inline list<__ss_int> *list_comp_13() {
    __ss_int __95, __96, var;

    list<__ss_int> *__ss_result = new list<__ss_int>();

    FAST_FOR(var,1,(nrofvars+1),1,95,96)
        if ((fixedt->__getfast__(var)==(-1))) {
            __ss_result->append(var);
        }
    END_FOR

    return __ss_result;
}

static inline __ss_int __lambda0__(__ss_int x, __ss_int y) {
    
    return ((((1024*x)*y)+x)+y);
}

__ss_int _reduce(lambda0 f, list<__ss_int> *l, __ss_int i) {
    __ss_int __0, __1, r;

    if (__NOT(___bool(l))) {
        if ((i!=(-1))) {
            return i;
        }
        print2(NULL,0,1, const_3);
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

__ss_int solve_rec() {
    __iter<__ss_int> *__37;
    list<__ss_int> *__36, *la_mods, *prop_mods;
    __ss_int __38, __40, __41, choice, var;
    list<__ss_int>::for_in_loop __39;

    nodecount = (nodecount+1);
    if ((nodecount==100)) {
        return 1;
    }
    if (__NOT((fixedt->__slice__(1, 1, 0, 0))->__contains__((-1)))) {
        print2(NULL,0,2, const_4, (const_5)->join(list_comp_6()));
        return 1;
    }
    la_mods = (new list<__ss_int>());
    var = lookahead(la_mods);
    if (__NOT(var)) {
        return backtrack(la_mods);
    }

    FOR_IN(choice,(new list<__ss_int>(2,var,(-var))),36,38,39)
        prop_mods = (new list<__ss_int>());
        if ((propagate(choice, prop_mods, 0) and solve_rec())) {
            return 1;
        }
        backtrack(prop_mods);
    END_FOR

    return backtrack(la_mods);
}

__ss_int propagate(__ss_int lit, list<__ss_int> *mods, __ss_int failed_literal) {
    tuple2<__ss_int, __ss_int> *__46;
    __iter<list<__ss_int> *> *__43;
    list<list<__ss_int> *>::for_in_loop __45;
    list<__ss_int> *clause;
    list<list<__ss_int> *> *__42;
    __ss_int __44, current, length, unfixed;

    current = len(mods);
    mods->append(lit);

    while (1) {
        if ((fixedt->__getfast__(__abs(lit))==(-1))) {
            fixedt->__setitem__(__abs(lit), __int(___bool((lit>0))));
            propcount = (propcount+1);
            mask_propagate(lit);

            FOR_IN(clause,occurrence->__getfast__((-lit)),42,44,45)
                __46 = info(clause);
                length = __46->__getfirst__();
                unfixed = __46->__getsecond__();
                if ((length==0)) {
                    return 0;
                }
                else if ((length==1)) {
                    mods->append(unfixed);
                }
                else if ((length==2)) {
                    bincount = (bincount+1);
                    if (failed_literal) {
                        mask_binclause(unfixed_lits(clause));
                    }
                }
            END_FOR

        }
        else if ((fixedt->__getfast__(__abs(lit))!=__int(___bool((lit>0))))) {
            return 0;
        }
        current = (current+1);
        if ((current==len(mods))) {
            break;
        }
        lit = mods->__getfast__(current);
    }
    return 1;
}

void *mask_propagate(__ss_int lit) {
    list<__ss_int> *__47;
    __ss_int __48;

    __47 = lit_mask;
    __48 = lit;
    __47->__setitem__(__48, ((__47->__getfast__(__48))|(part_mask)));
    return NULL;
}

void *mask_binclause(list<__ss_int> *lits) {
    __iter<__ss_int> *__50;
    list<__ss_int> *__49;
    __ss_int __51, lit;
    list<__ss_int>::for_in_loop __52;


    FOR_IN(lit,lits,49,51,52)
        global_mask = ((global_mask)|(lit_mask->__getfast__((-lit))));
    END_FOR

    return NULL;
}

__ss_int lookahead(list<__ss_int> *mods) {
    __iter<__ss_int> *__70, *__78;
    list<__ss_int>::for_in_loop __72, __80;
    __ss_bool __73, __74;
    list<__ss_int> *__67, *__69, *__77, *dif, *masks, *part, *u;
    list<list<__ss_int> *> *parts;
    __ss_int __65, __66, __68, __71, __79, i, var;

    global_mask = hoppa;
    lit_mask = list_comp_7();
    u = unfixed_vars();
    parts = list_comp_8(u);
    masks = list_comp_9();
    some_failure = 0;
    dif = list_comp_10();

    while ((global_mask!=0)) {
        lit_mask = list_comp_11();

        FAST_FOR(i,0,32,1,65,66)
            __67 = parts->__getfast__(i);
            __68 = masks->__getfast__(i);
            part = __67;
            part_mask = __68;
            if ((((global_mask)&(part_mask))==0)) {
                continue;
            }
            global_mask = ((global_mask)&(((hoppa)^(part_mask))));

            FOR_IN(var,part,69,71,72)
                if (((fixedt->__getfast__(var)==(-1)) and __NOT(lookahead_variable(var, mods, dif)))) {
                    return 0;
                }
            END_FOR

        END_FOR

    }
    if (some_failure) {
        dif = list_comp_12();

        FOR_IN(var,unfixed_vars(),77,79,80)
            if (__NOT(lookahead_variable(var, mods, dif))) {
                print2(NULL,0,1, const_6);
            }
        END_FOR

    }
    return dif->index(___max(1, 0, dif));
}

__ss_int lookahead_variable(__ss_int var, list<__ss_int> *mods, list<__ss_int> *dif) {
    __iter<__ss_int> *__82;
    list<__ss_int> *__81, *prop_mods, *score;
    __ss_int __83, choice, prop;
    list<__ss_int>::for_in_loop __84;

    score = (new list<__ss_int>());

    FOR_IN(choice,(new list<__ss_int>(2,var,(-var))),81,83,84)
        prop_mods = (new list<__ss_int>());
        bincount = 0;
        prop = propagate(choice, prop_mods, 0);
        backtrack(prop_mods);
        if (__NOT(prop)) {
            some_failure = 1;
            if (__NOT(propagate((-choice), mods, 1))) {
                return 0;
            }
            break;
        }
        score->append(bincount);
    END_FOR

    dif->__setitem__(var, _reduce(__lambda0__, score, 0));
    return 1;
}

__ss_int backtrack(list<__ss_int> *mods) {
    __iter<__ss_int> *__86;
    list<__ss_int> *__85;
    __ss_int __87, lit;
    list<__ss_int>::for_in_loop __88;


    FOR_IN(lit,mods,85,87,88)
        fixedt->__setitem__(__abs(lit), (-1));
    END_FOR

    return 0;
}

tuple2<__ss_int, __ss_int> *info(list<__ss_int> *clause) {
    __iter<__ss_int> *__90;
    list<__ss_int> *__89;
    __ss_int __91, __93, __94, len, lit, unfixed;
    list<__ss_int>::for_in_loop __92;

    len = 0;
    unfixed = 0;

    FOR_IN(lit,clause,89,91,92)
        if ((fixedt->__getfast__(__abs(lit))==(-1))) {
            __93 = lit;
            __94 = (len+1);
            unfixed = __93;
            len = __94;
        }
        else if ((fixedt->__getfast__(__abs(lit))==__int(___bool((lit>0))))) {
            return (new tuple2<__ss_int, __ss_int>(2,(-1),0));
        }
    END_FOR

    return (new tuple2<__ss_int, __ss_int>(2,len,unfixed));
}

list<__ss_int> *unfixed_vars() {
    
    return list_comp_13();
}

list<__ss_int> *unfixed_lits(list<__ss_int> *clause) {
    __iter<__ss_int> *__98;
    list<__ss_int> *__97, *result;
    __ss_int __99, lit;
    list<__ss_int>::for_in_loop __100;

    result = (new list<__ss_int>());

    FOR_IN(lit,clause,97,99,100)
        if ((fixedt->__getfast__(__abs(lit))==(-1))) {
            result->append(lit);
        }
    END_FOR

    return result;
}

void __init() {
    const_0 = new str("c0%\n");
    const_1 = new str("");
    const_2 = __char_cache[112];;
    const_3 = new str("*** ERROR! *** reduce() called with empty sequence and no initial value");
    const_4 = __char_cache[118];;
    const_5 = __char_cache[32];;
    const_6 = new str("error");
    const_7 = new str("testdata/uuf250-010.cnf");
    const_8 = new str("unsatisfiable");
    const_9 = new str("nodes");
    const_10 = new str("propagations");

    __name__ = new str("__main__");

    argv = (new list<str *>(2,const_1,const_7));
    cnf = list_comp_0();
    clauses = list_comp_2();
    nrofvars = (list_comp_3())->__getfast__(0);
    vars = range((nrofvars+1));
    occurrence = list_comp_4();

    FOR_IN(clause,clauses,22,24,25)

        FOR_IN(lit,clause,26,28,29)
            (occurrence->__getfast__(lit))->append(clause);
        END_FOR

    END_FOR

    fixedt = list_comp_5();
    nodecount = 0;
    propcount = 0;
    hoppa = 4294967295;
    if (__NOT(solve_rec())) {
        print2(NULL,0,1, const_8);
    }
    print2(NULL,0,4, const_9, ___box(nodecount), const_10, ___box(propcount));
}

} // module namespace

int main(int, char **) {
    __shedskin__::__init();
    __shedskin__::__start(__37__::__init);
}
