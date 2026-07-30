import React from "react";

interface ICardProps {
    id: string;
    image: string;
    name: string;
}

const Card = ({ id, image, name }: ICardProps) => {
    return (
        <div id={id} className={`box-border size-32 border`}>
            <img src={`${image}`} alt={name} />
            <p>{name}</p>
        </div>
    )
};

export default Card;