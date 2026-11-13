const m1 = new Map();
const m2 = new Map<string, unknown>();
const m3 = new Map<string, unknown>(1, 2);
const m4 = new Map(1);
const m5 = foo<string>(1);
const m6 = new Array<string>();
const m7 = new Set<number>();
const date = new Date(0);
const anon = new (class extends Base<string> {
    run(): void {
    }
})("named", 2);
