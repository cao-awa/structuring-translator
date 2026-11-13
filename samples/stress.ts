// A deliberately broad ES6 + TypeScript sample used to exercise the lexer, the parser and the
// Kotlin script emitter in one pass.

import defaultExport, { named as renamed, other } from "./module";
import * as ns from "./ns";
import "./side-effect";

export interface Shape<T> {
    readonly name: string;
    area(scale?: number): number;
    tag: T;
}

export type Pair<A, B> = [A, B];
export type Handler = (event: string, payload: unknown) => void;
type Maybe<T> = T | null | undefined;

export enum Color {
    Red,
    Green = 2,
    Blue = "blue",
}

export const enum Flag {
    On = 1,
    Off = 0,
}

namespace Geometry {
    export const origin = { x: 0, y: 0 };
    export function distance(ax: number, ay: number): number {
        return Math.sqrt(ax * ax + ay * ay);
    }
}

export abstract class BaseShape<T> implements Shape<T> {
    static count = 0;
    readonly name: string = "base";
    protected tag: T;
    private secret?: string;
    #hidden = 0;

    constructor(name: string, tag: T) {
        this.name = name;
        this.tag = tag;
        BaseShape.count += 1;
    }

    abstract area(scale?: number): number;

    get label(): string {
        return `${this.name}:${BaseShape.count}`;
    }

    set label(value: string) {
        this.secret = value;
    }

    static create<U>(tag: U): BaseShape<U> {
        return new (class extends BaseShape<U> {
            area(): number {
                return 0;
            }
        })("anon", tag);
    }

    describe = (prefix: string): string => `${prefix} ${this.name}`;
}

export class Circle extends BaseShape<number> {
    radius: number;

    constructor(radius: number) {
        super("circle", radius);
        this.radius = radius;
    }

    area(scale: number = 1): number {
        return Math.PI * this.radius * this.radius * scale;
    }
}

export function compose<A, B, C>(f: (b: B) => C, g: (a: A) => B): (a: A) => C {
    return (a: A) => f(g(a));
}

function overloaded(value: string): string;
function overloaded(value: number): number;
function overloaded(value: any): any {
    return value;
}

const arrowBlock = (a: number, b: number): number => {
    const sum = a + b;
    return sum * 2;
};

const arrowExpr = (a: number) => a * 3;
const single = x => x + 1;
const noArgs = () => "constant";

let auto: string;
let inferred = 42;
var legacy = true;
const template = `head ${inferred + 1} middle ${auto ?? "none"} tail`;

const array = [1, 2, 3];
const nested = [[1], [2, [3]]];
const spread = [...array, 4];
const object = { a: 1, b: "two", nested: { deep: true }, array, ...spread };
const computedKey = { ["k" + 1]: 1, [inferred]: 2 };
const withMethod = {
    value: 1,
    double(this: any) {
        return this.value * 2;
    },
};
const methods = {
    get size(): number {
        return 0;
    },
    run(): void {
    },
};

const regex = /ab+c/gi;
const json = JSON.parse("{}") as Record<string, unknown>;
const asserted = <string>auto;
const satisfied = { id: 1 } satisfies Record<string, number>;
const chained = object?.nested?.deep;
const nullish = auto ?? "fallback";
const ternary = inferred > 0 ? "positive" : "other";
const bitwise = (inferred & 0xff) | 1;
const shifted = inferred << 2;
const power = 2 ** 10;
const inOp = "a" in object;
const typeOf = typeof inferred === "number";

function controlFlow(items: number[]): void {
    let total = 0;
    for (let i = 0; i < items.length; i++) {
        total += items[i];
        if (total > 10) {
            break;
        } else if (total > 5) {
            continue;
        } else {
            total -= 1;
        }
    }

    for (const item of items) {
        total += item;
    }

    for (const key in object) {
        console.log(key);
    }

    while (total > 0) {
        total--;
    }

    do {
        total++;
    } while (total < 3);

    switch (total) {
        case 0:
            console.log("zero");
            break;
        case 1:
        case 2:
            console.log("small");
            break;
        default:
            console.log("large");
            break;
    }

    try {
        throw new Error("boom");
    } catch (error) {
        console.error(error);
    } finally {
        console.log("done");
    }

    outer: for (const i of items) {
        for (const j of items) {
            if (i === j) {
                continue outer;
            }
        }
    }
}

async function loadAll(urls: string[]): Promise<string[]> {
    const results: string[] = [];
    await Promise.all(
        urls.map(async url => {
            const response = await fetch(url);
            results.push(await response.text());
        }),
    );
    return results;
}

export function* counter(limit: number) {
    for (let i = 0; i < limit; i++) {
        yield i;
    }
}

export default class Registry {
    private readonly entries = new Map<string, unknown>();

    register(key: string, value: unknown): this {
        this.entries.set(key, value);
        return this;
    }
}

console.log("translated", template.length);
