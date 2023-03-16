import { DangerType } from "./DangerType";

export class DangerName {
    constructor(
        public id: number,
        public dangerNumber?: number,
        public description?: string,
        public dangerType?: DangerType
    ) {

    }
}