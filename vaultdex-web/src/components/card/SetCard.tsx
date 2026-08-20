import React from "react";
import Button from "../button/Button";
import { useTrackSet } from "../../hooks/useTrackedSets";

interface ISetCardProps {
    setId: string;
    setName: string;
    setLogoUrl: string;
    onClick: () => void;
}

const SetCard = ({ setId, setName, setLogoUrl, onClick }: ISetCardProps) => {
    const trackSetMutation = useTrackSet();

    const trackSet = (e: React.MouseEvent<HTMLButtonElement>) => {
        e.stopPropagation();
        trackSetMutation.mutate({ setCode: setId });
    }

    return (
        <div
            key={setId}
            className="grid grid-cols-1 gap-4 p-4 border rounded-md shadow-md justify-items-center w-full max-w-sm min-h-40"
            onClick={onClick}
        >
            <Button label="Star" className="mb-2" onClick={trackSet} />
            <img src={setLogoUrl} alt={setName} className="h-24 w-full object-contain" />
            <h3 className="text-center">{setName}</h3>
        </div>
    );
};

export default SetCard;