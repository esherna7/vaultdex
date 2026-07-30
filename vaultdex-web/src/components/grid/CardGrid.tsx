import React from "react";

const CardGrid = ({ children }: { children: React.ReactNode }) => {
    return (
        <div className="grid grid-cols-4 gap-4">
            {children}
        </div>
    );
};

export default CardGrid;