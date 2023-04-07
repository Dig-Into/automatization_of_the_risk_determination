import { Probability } from "./Probability";
import { Effect } from "./Effect";
import { Frequency } from "./Frequency";
import { DangerName } from "./DangerName";

export class DangerDetails {
    constructor(
        public id: number,
        public code?: number,
        public value?: number,
        public descriptions?: string[],
        public probability?: Probability,
        public effect?: Effect,
        public frequency?: Frequency,
        public dangerName?: DangerName
    ) {

    }
}