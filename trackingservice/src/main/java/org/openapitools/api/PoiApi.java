/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.0-beta).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.POI;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-07-30T17:09:16.737885200+05:30[Asia/Calcutta]")
@Validated
@Tag(name = "POI", description = "Points of interest (POI) are a combination of location and additional details about that specific location. A POI can be a single LatLong or a polygon (combination of multiple LatLongs)")
public interface PoiApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /poi/_create : Create a new POI by providing location coordinates and additional details
     * Create a new POI by Id
     *
     * @param POI Create a new POI in the system (required)
     * @return Successful operation (status code 200)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "createPOI",
        summary = "Create a new POI by providing location coordinates and additional details",
        description = "Create a new POI by Id",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/poi/_create",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> createPOI(
        @Parameter(name = "POI", description = "Create a new POI in the system", required = true) @Valid @RequestBody POI POI
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /poi/_search : Finds POIs based on a specific parameters
     * Search POIs based on multiple filters
     *
     * @param status Status values that need to be considered for filter (optional, default to active)
     * @param locationName Location name that needs to be considered for filter (optional)
     * @return successful operation (status code 200)
     *         or Invalid search value (status code 400)
     */
    @Operation(
        operationId = "findPOI",
        summary = "Finds POIs based on a specific parameters",
        description = "Search POIs based on multiple filters",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = POI.class)))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid search value")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poi/_search",
        produces = { "application/json" }
    )
    default ResponseEntity<List<POI>> findPOI(
        @Parameter(name = "status", description = "Status values that need to be considered for filter", in = ParameterIn.QUERY) @Valid @RequestParam(value = "status", required = false, defaultValue = "active") String status,
        @Parameter(name = "locationName", description = "Location name that needs to be considered for filter", in = ParameterIn.QUERY) @Valid @RequestParam(value = "locationName", required = false) String locationName
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"locationName\" : \"Any name assigned to the location\", \"alert\" : [ \"alert\", \"alert\" ], \"audit\" : { \"createdDate\" : \"2023-07-30T10:24:10.547Z\", \"updatedBy\" : \"Id of the user who updated the entity\", \"createdBy\" : \"Id of the user who created the entity\", \"updatedDate\" : \"2023-07-30T10:24:10.547Z\" }, \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"status\" : \"active\" }, { \"locationName\" : \"Any name assigned to the location\", \"alert\" : [ \"alert\", \"alert\" ], \"audit\" : { \"createdDate\" : \"2023-07-30T10:24:10.547Z\", \"updatedBy\" : \"Id of the user who updated the entity\", \"createdBy\" : \"Id of the user who created the entity\", \"updatedDate\" : \"2023-07-30T10:24:10.547Z\" }, \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"status\" : \"active\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /poi/{poiId} : Find POI by its id
     * Returns a single POI
     *
     * @param poiId ID of POI to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or POI not found (status code 404)
     */
    @Operation(
        operationId = "getPoiById",
        summary = "Find POI by its id",
        description = "Returns a single POI",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = POI.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "POI not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/poi/{poiId}",
        produces = { "application/json" }
    )
    default ResponseEntity<POI> getPoiById(
        @Parameter(name = "poiId", description = "ID of POI to return", required = true, in = ParameterIn.PATH) @PathVariable("poiId") String poiId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"locationName\" : \"Any name assigned to the location\", \"alert\" : [ \"alert\", \"alert\" ], \"audit\" : { \"createdDate\" : \"2023-07-30T10:24:10.547Z\", \"updatedBy\" : \"Id of the user who updated the entity\", \"createdBy\" : \"Id of the user who created the entity\", \"updatedDate\" : \"2023-07-30T10:24:10.547Z\" }, \"locationDetails\" : [ { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 }, { \"latitude\" : 0.8008282, \"longitude\" : 6.0274563 } ], \"id\" : \"id\", \"type\" : \"point\", \"status\" : \"active\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /poi/_update : Update an existing POI using its id
     * Update an existing POI by Id
     *
     * @param POI Update an existent POI in the system (required)
     * @return Successful operation (status code 200)
     *         or Invalid POI ID is supplied (status code 400)
     *         or POI not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @Operation(
        operationId = "updatePOI",
        summary = "Update an existing POI using its id",
        description = "Update an existing POI by Id",
        tags = { "POI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid POI ID is supplied"),
            @ApiResponse(responseCode = "404", description = "POI not found"),
            @ApiResponse(responseCode = "405", description = "Validation exception")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/poi/_update",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updatePOI(
        @Parameter(name = "POI", description = "Update an existent POI in the system", required = true) @Valid @RequestBody POI POI
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
