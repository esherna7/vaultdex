import React from "react";
import { useNavigate } from "react-router-dom";
import SetCard from "../components/card/SetCard";

const trackedSets = [
    { id: "sv08.5", name: "Prismatic Evolutions", logo: "https://assets.tcgdex.net/en/sv/sv08.5/logo.png" },
    { id: "me02", name: "Phantasmal Flames", logo: "https://assets.tcgdex.net/en/me/me02/logo.png" },
    { id: "me03", name: "Perfect Order", logo: "https://assets.tcgdex.net/en/me/me03/logo.png" },
    { id: "me04", name: "Chaos Rising", logo: "https://assets.tcgdex.net/en/me/me04/logo.png" },
    { id: "me05", name: "Pitch Black", logo: "https://assets.tcgdex.net/en/me/me05/logo.png" },
    { id: "me02.5", name: "Ascended Heroes", logo: "https://assets.tcgdex.net/en/me/me02.5/logo.png" },
];

const Dashboard = () => {
    const navigate = useNavigate();

    const handleSetClick = (setId: string) => {
        navigate(`/sets/${setId}`);
    };

    return (
        <div>
            <h1>Dashboard</h1>
            <div>Tracked Sets</div>
            <div className="grid grid-cols-4 gap-4 place-items-center">
                {trackedSets.map((set) => (
                    <SetCard
                        key={set.id}
                        setId={set.id}
                        setName={set.name}
                        setLogoUrl={set.logo}
                        onClick={() => handleSetClick(set.id)}
                    />
                ))}
            </div>
        </div>
    );
};

export default Dashboard;